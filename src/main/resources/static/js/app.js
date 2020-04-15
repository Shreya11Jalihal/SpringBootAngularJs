var myApp = angular.module('myApp', [ 'ngResource', 'ngMessages' ]);
myApp.controller('signupController', function($scope, $http) {
	$scope.name;
	$scope.password;
	$scope.email;

	$scope.onClick = function(name, password, email) {
		// creating a object that we will pass it to http post request
		var data = {
			name : name,
			password : password,
			email : email

		}
		// Ajax call for saving the user Data
		$http.post('http://localhost:9095/saveUser', JSON.stringify(data))
				.then(function(response) {
					console.log(response);
					if (angular.isObject(response.data)) {
						alert("User saved!");
					}
					else
						{
						alert("User is already registered");
						}
					console.log(response.data);
					function clearForm() {
						$scope.name = {};
						$scope.password = null;
						$scope.email = null;
					}
				});
	}

});