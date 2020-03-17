var myApp = angular.module('myApp', [ 'ngResource', 'ngMessages' ]);
myApp.controller('myController', function($scope, $http) {
	$scope.flag=true;
	$scope.name = null;
	$scope.password = null;
	$scope.email = null;

	$scope.onClick = function(name, password, email) {
		// creating a object that we will pass it to htt post
		var data = {
			name : name,
			password : password,
			email : email

		}
		// Ajax call for saving the user Data
		$http.post('http://localhost:9095/saveUser', JSON.stringify(data))
				.then(function(response) {
					console.log(response);
					if (response.data) {
						alert("User saved!");
						$scope.responsename = response.data.name;
						$scope.flag = true;
						//clearForm();
					}
					console.log(response.data);

					function clearForm() {
						$scope.name = {};
						$scope.password = null;
						$scope.email = null;
						$scope.mand = false;
						
					}

				});
	}

});