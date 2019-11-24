
import React, { Component } from 'react';
import {
    SafeAreaView,
    StyleSheet,
    ScrollView,
    View,
    FlatList,
    Text,
    StatusBar,
    Dimensions
} from 'react-native';
import axios from 'axios';
import EmailItem from './EmailItem'
let width = Dimensions.get('window').width;
let height = Dimensions.get('window').height;
export default class HomeScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    }
    async componentDidMount() {

        let response = await axios.get("http://5dd8ff6518c0a500145762b9.mockapi.io/Email")
        this.setState({
            data: response.data

        })
    }
    render() {  
      
        return (
            <View style={[{ backgroundColor: '#fafafa' }, styles.container]}>
                <FlatList
                    keyExtractor={item => item.id}
                    data={this.state.data}
                    renderItem={({ item }) =>
                        <EmailItem
                            {...this.props}
                            id = {item.id}
                            sender={item.sender}
                            title={item.title}
                            description={item.description}
                        />
                    }

                />
            </View>

        );
    }



}

let styles = StyleSheet.create({
    container: {
        width: width,
        height: height

    }



})