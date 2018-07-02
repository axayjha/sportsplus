
var app = angular.module("app", [ "ngRoute" ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html'
	});
	$routeProvider.when('/academy', {
		templateUrl : 'academy.html',
		controller : 'academyCtrl'
	});
	$routeProvider.when('/schedule', {
		templateUrl : 'schedule.html',
		controller : 'scheduleCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);

app.controller("academyCtrl", function($scope, $http) {

	$scope.fetchAcademy = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/academy/getAll'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.academies = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveAcademy = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/academy/add',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.academy
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchAcademy();
			$scope.academies = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.deleteAcademy = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/academy/delete',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.academy
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchAcademy();
			$scope.academies = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.updaateAcademy = function() {
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/academy/update',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.academy
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchAcademy();
			$scope.academies = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("scheduleCtrl", function($scope, $http) {

	

})