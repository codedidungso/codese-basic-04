import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';


import HomeScreen from "./screens/HomeScreen";
import DetailScreen from "./screens/DetailScreen";
import MainNavigator from "./navigation/MainNavigator";
const App: () => React$Node = () => {

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView style={{ backgroundColor: 'black' }}>

        <MainNavigator /> 
        {/* <HomeScreen />
        {/* <DetailScreen /> */}

      </SafeAreaView>
    </>
  );
};


export default App;
