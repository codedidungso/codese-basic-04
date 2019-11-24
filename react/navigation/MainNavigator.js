import { createAppContainer } from 'react-navigation';
import { createStackNavigator } from 'react-navigation-stack';
import HomeScreen from '../screens/HomeScreen';
import DetailScreen from '../screens/DetailScreen';

const MainNavigator = createStackNavigator({
  HomeScreen: { screen: HomeScreen },
  DetailScreen: { screen: DetailScreen },
},
  {
    initialRouteName:'HomeScreen'
  });

const MainNavigation = createAppContainer(MainNavigator);

export default MainNavigation;