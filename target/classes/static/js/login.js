var login = angular.module('login', [ 'ngResource' ]);
login.controller('signincontroller', function($scope, $http) {
	$scope.name;
	$scope.password;
	$scope.flag=true;
	$scope.onClick = function(email, password) {
		var data = {
			name : name,
			email : email,
			password : password,
		}
		//Ajax call to verify user's data 
		$http.post('http://localhost:9095/validateUser', JSON.stringify(data))
				.then(function(response) {
					if (angular.equals(response.data.email,$scope.email)) {
						alert("Login Successful");
					} else {
						alert('User validation failed');
					}
				});
	}

});
