/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksecurityproject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class ServerClientThread extends Thread {

    Socket serverClient;
    int clientNo;
    int squre;
    String user;
    String pass;
    String adminOf = "";

    ServerClientThread(Socket inSocket, int counter) {
        serverClient = inSocket;
        clientNo = counter;
    }

    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            ArrayList<String> list_users = new ArrayList<>();
            String clientMessage = "", serverMessage = "";
            boolean isLogin = false;
            while (!clientMessage.equals("-exit")) {
                clientMessage = inStream.readUTF();
                System.out.println("Command from client " + clientNo + " :" + clientMessage);
                //help
                if (clientMessage.equals("-help")) {
                    if (isLogin) {
                        serverMessage = "logined "; // -login
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                    } else {
                        serverMessage = "-login: login app with your account \n-regist: create a new account \n-exit: exit  "; // -login
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                    }

                } // login
                else if (clientMessage.equals("-login")) {
                    if (isLogin) {
                        outStream.writeUTF("Aready logined");
                        outStream.flush();
                    } else {
                        outStream.writeUTF("Enter < username:password > ");
                        outStream.flush();
                        clientMessage = inStream.readUTF();
                        BufferedReader reader;
                        String[] User0Pass1 = new String[2];
                        User0Pass1[0] = "";
                        User0Pass1[1] = "";
                        int temp = 0;
                        for (int i = 0; i < clientMessage.length(); i++) {
                            if (clientMessage.charAt(i) == ':') {
                                temp++;
                                continue;
                            }
                            User0Pass1[temp] += clientMessage.charAt(i);
                        }
                        user = User0Pass1[0];
                        pass = User0Pass1[1];
                        try {
                            reader = new BufferedReader(new FileReader(".\\data\\admindata\\info_users.txt"));
                            String line = reader.readLine();
                            while (line != null) {
                                list_users.add(line);
                                line = reader.readLine();
                            }

                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int x;
                        for (x = 0; x < list_users.size(); x++) {
                            String[] xUserPass = new String[2];
                            xUserPass[0] = "";
                            xUserPass[1] = "";
                            String userAtX = (String) list_users.get(x);
                            int tempp = 0;
                            for (int i = 0; i < userAtX.length(); i++) {
                                if (userAtX.charAt(i) == ':') {
                                    tempp++;
                                    continue;
                                }
                                xUserPass[tempp] += userAtX.charAt(i);
                            }

                            if (xUserPass[0].equals(User0Pass1[0]) && xUserPass[1].equals(User0Pass1[1])) {
                                x--;
                                break;
                            }
                        }
                        if (x == list_users.size()) {
                            System.out.println("Username and password not found");
                            outStream.writeUTF("Invalid Username or Password");
                            outStream.flush();
                        } else {
                            isLogin = true;
                            System.out.println("user: " + User0Pass1[0]);
                            System.out.println("pass: " + User0Pass1[1]);
                            outStream.writeUTF("Hi " + User0Pass1[0] + "!");

                        }
                    }
                } //register
                else if (clientMessage.equals("-regist")) {
                    if (isLogin) {
                        outStream.writeUTF("Not valid");
                        outStream.flush();
                    } else {
                        outStream.writeUTF("username: ");
                        outStream.flush();
                        String user = inStream.readUTF();
                        outStream.writeUTF("pass: ");
                        outStream.flush();
                        String pass = inStream.readUTF();
                        ArrayList<String> arrList = new ArrayList<>();
                        BufferedReader reader;
                        File f = new File(".\\data\\admindata\\info_users.txt");
                        try {
                            reader = new BufferedReader(new FileReader(".\\data\\admindata\\info_users.txt"));
                            String line = reader.readLine();
                            while (line != null) {
                                arrList.add(line);
                                line = reader.readLine();
                            }

                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        boolean isExistAccount = false;
                        for (int x = 0; x < arrList.size(); x++) {
                            if (arrList.get(x).contains(user + ":" + pass)) {
                                isExistAccount = true;
                                break;
                            }
                        }
                        if (isExistAccount) {
                            outStream.writeUTF("Regist failed, try again");
                            outStream.flush();
                        } else {
                            FileWriter fr = new FileWriter(f, true);
                            fr.write("\r\n" + user + ":" + pass);
                            fr.flush();
                            fr.close();
                            outStream.writeUTF("done");
                            outStream.flush();
                        }

                    }

                } //createGroup
                else if (clientMessage.equals("-createGroup")) {
                    if (isLogin) {
                        outStream.writeUTF("group_name:");
                        outStream.flush();
                        String groupName = inStream.readUTF();
                        File f = new File(".\\data\\userdata\\Groups\\" + groupName);
                        if (f.exists()) {
                            outStream.writeUTF("group existed, try again!");
                            outStream.flush();
                        } else {
                            f.mkdir();
                            File f2 = new File(f.getPath() + "/info.txt");
                            f2.createNewFile();
                            FileWriter fr2 = new FileWriter(f2, true);
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            Date date = new Date();
                            fr2.write(user + "\r\n" + "Created at :" + formatter.format(date));
                            fr2.flush();
                            fr2.close();
                            outStream.writeUTF("group created");
                            outStream.flush();
                        }
                    } else {
                        outStream.writeUTF("You must login first ");
                        outStream.flush();
                    }
                }//showInfo
                else if (clientMessage.equals("-info")) {
                    if (isLogin) {
                        //get admin Info
                        File f = new File(".\\data\\userdata\\Groups");
                        adminOf = "";
                        for (File file : f.listFiles()) {
                            File readme = new File(file + "\\" + "info.txt");
                            BufferedReader readerReadme = new BufferedReader(new FileReader(readme));
                            String temp = readerReadme.readLine();
                            if (user.equals(temp)) {
                                if (adminOf.equals("")) {
                                    adminOf += file.getName();
                                } else {
                                    adminOf += ", " + file.getName();
                                }
                            }

                        }
                        outStream.writeUTF("Account:" + user + "\nLeadGroup:" + adminOf);
                        outStream.flush();
                        //
                    } else {
                        outStream.writeUTF("You must login first");
                        outStream.flush();
                    }
                }//showGroup
                else if (clientMessage.equals("-showGroups")) {
                    File f = new File(".\\data\\userdata\\Groups");
                    String data = "";
                    for (File files : f.listFiles()) {
                        data += files.getName() + "\n";
                    }
                    outStream.writeUTF(data);
                    outStream.flush();
                }

            }
            inStream.close();
            outStream.close();
            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
