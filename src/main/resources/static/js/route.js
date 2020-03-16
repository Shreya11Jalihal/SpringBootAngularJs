var myApplication = angular.module('myApp', [ 'ngRoute' ]);
myApplication.config(function($routeProvider) {
	$routeProvider
	.when('/',{
		
		templateUrl :'/templates/index.html',
        controller :'myController'
	})
	
	.when('/thyme',{
       
        templateUrl :'/templates/thyme.html',
        controller :'secondController'
    })

});