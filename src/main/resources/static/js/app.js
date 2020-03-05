var myApp = angular.module('myApp', [ 'ngResource' ]);
myApp.controller('myController', function($scope, $http) {

	$scope.onClick = function() {
		alert("clicked");
		$scope.Name = $scope.newData;
		console.log($scope);
			var data = {
				fname : $scope.Name.fName,
				lname : $scope.Name.lName,

			};
			console.log(data);
		//Ajax call for saving the user Data
		$http.post('http://localhost:8081/saveUser', JSON.stringify(data)).then(function(response) {
			if (response.data) {
				$scope.msg = "Post Data submitted Successfully";
			}

		});

		
		
	}

});