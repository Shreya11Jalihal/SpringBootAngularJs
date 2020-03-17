var login = angular.module('login', ['ngResource']);
login.controller('signincontroller', function($scope,$http) {
	$scope.name = null;
	$scope.password = null;

	$scope.onClick = function(email, password) {
		var data = {
			email : email,
			password : password,

		}

		$http.get('http://localhost:9095/getUser/',{params :{data:data}}, JSON.stringify(data))
		.then(function(response) {
			console.log(response);
			if (response.data) {
				alert("Login Successful");
				$scope.responsename = response.data.name;
				$scope.flag = true;
				
			}
			console.log(response.data);
		});

	}

});
