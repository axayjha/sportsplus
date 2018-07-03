
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
	$scope.updateAcademy = function() {
		$http({
			method : 'POST',
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
	//Creating validations and functions
	
	//Validation if the fields are empty or not
	var addScheduleValidate = function(scheduleObject){
		Object.keys(scheduleObject).forEach(function(key){
			if(scheduleObject[key] == ""){
				return false;
			}
			return true;
		});
	};

	
	//Linking to HTML
	//Add Schedule
	$scope.addSchedule = function(newSchedule){
		var checkIfOkay = addScheduleValidate(newSchedule);
		//Check if selected date is greater than current date date
		var date = new Date();
		if(newSchedule.date < date){
			$scope.dateMessage = "Selected Date should be greater than current date";
			checkIfOkay = false;
		}
		if(checkIfOkay){
			$http({
				method : 'POST',
				url : 'http://localhost:8080/schedule/add',
				headers: { 'Content-Type': 'application/json' },
				data:newSchedule
			}).success(function(data, status) {
				console.log(data);
				$scope.message = "Sucessfully Added. You are good to go";
			}).error(function(data, status) {
				$scope.status = status;
				$scope.data = "Request failed";
			});
		}else{
			$scope.message = "Fields were left empty. Please fill in the requires Details";
		}
		
	};
	



});