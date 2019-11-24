import React, { Component } from 'react';
import {
    SafeAreaView,
    StyleSheet,
    ScrollView,
    View,
    FlatList,
    Text,
    StatusBar,
    TouchableOpacity,
    Image,
    Dimensions
} from 'react-native';
import { cyan } from 'ansi-colors';

const itemWidth = Dimensions.get('window').width;
const itemHeigh = Dimensions.get('window').height / 10;

function pressFunction() {


}


export default function EmailItem(props) {
    const { navigate } = props.navigation;
    return (
        <TouchableOpacity

            style={styles.container}
            onPress={() => {
                navigate('DetailScreen', {
                    id: props.id,
                    sender: props.sender
                })
            }}

        >
            <Image style={styles.image}
                source={{ uri: props.sender }}
            />
            <View style={styles.viewData}>
                <View style={styles.view1}>
                    <Text>{props.title}</Text>
                </View>
                <View style={styles.view2}>
                    <Text>{props.description}</Text>
                </View>
            </View>
        </TouchableOpacity>
    )
}
const styles = StyleSheet.create({
    container: {
        width: itemWidth,
        height: itemHeigh,
        alignItems: 'center',
        flexDirection: 'row',
        backgroundColor: '#fafad2',
        borderBottomWidth: 0.3,
        borderBottomColor: 'gray'
    },
    image: {
        height: itemHeigh * 0.8,
        width: itemHeigh * 0.8,
        borderRadius: itemHeigh * 0.8 / 2,
        marginLeft: 5
    },
    viewData: {
        flex: 1,
        flexDirection: 'column',
        marginLeft: 10
    },
    view1: {
        flex: 1,
    },
    view2: {
        flex: 1,
    }
})