
import React, { Component } from 'react';
import {
    SafeAreaView,
    StyleSheet,
    ScrollView,
    View,
    FlatList,
    Text,
    Image,
    StatusBar,
    Dimensions
} from 'react-native';
import axios from 'axios';
import EmailItem from './EmailItem'
let windowWidth = Dimensions.get('window').width;
let windowHeight = Dimensions.get('window').height;

export default class DetailScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        let itemID = this.props.navigation.getParam('id', 'no id');
        let data = this.props.navigation.getParam('sender', 'no sender');
        this.setState({
            data: {
                id: itemID,
                sender: data

            }

        })
    }
    render() {
       console.log("fuck");
        return (
            <View style={[{ backgroundColor: 'blue' }, styles.container]}>
                <View style={styles.imageField}>
                    <Image
                        style={styles.avatar}
                        source={{ uri: this.state.data.sender }}
                    ></Image>
                </View>
                <View style={styles.contentField}>

                </View>
            </View>

        );
    }



}

let styles = StyleSheet.create({
    container: {
        width: windowWidth,
        height: windowHeight,
        flexDirection: 'column'

    },
    imageField: {
        width: windowWidth,
        height: windowHeight / 2,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'white'

    },
    contentField: {
        width: windowWidth,
        height: windowHeight / 2

    },
    avatar: {
        width: (windowHeight / 2) * 0.7,
        height: (windowHeight / 2) * 0.7,
        borderRadius: (windowHeight / 2) * 0.7 / 2,
        backgroundColor: 'red',


    }



})