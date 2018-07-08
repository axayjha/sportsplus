
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
	$routeProvider.when('/group', {
		templateUrl : 'group.html',
		controller : 'groupCtrl'
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

app.controller("groupCtrl", function($scope, $http) {
	$scope.addGroup = function () {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/group/addGroup',
			data : $scope.group
		}).success(function(data, status) {
			alert("Group added");
		}).error(function(data, status) {
			$scope.status = status;
		});
	};
	
	$scope.getAllGroups = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/group/getGroups'
		}).success(function(data, status) {
			$scope.groups = data;
			
		}).error(function(data, status) {
			$scope.status = status;
		});
	};
	
	$scope.deleteGroup = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/group/deleteGroup',
			data : $scope.group
		}).success(function(data, status) {
			alert("Group deleted");
		}).error(function(data, status) {
			$scope.status = status;
		});
	};
	
	$scope.fetchGroup = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/group/getAGroup',
			data : $scope.group1
		}).success(function(data, status) {
			$scope.groupData = data;
		}).error(function(data, status) {
			$scope.status = status;
		});
	};
	
	$scope.updateGroup = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/group/updateGroup',
			data : $scope.group1
		}).success(function(data, status) {
			alert("updated");
		}).error(function(data, status) {
			$scope.status = status;
		});
	};
});
app.controller("scheduleCtrl", function($scope, $http) {
	

	$scope.init =function(){
		console.log("Init");
		var date = new Date();
		$scope.currentDate = formatDate(date);
		console.log($scope.currentDate);
		$scope.range4=[];
		for (var i = 1; i <= 12; i++) {
			$scope.range4.push(i);
		}
		console.log($scope.range4);
		getAll($http, $scope);
		$scope.editAllowed = true;
	};

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
	$scope.addSchedule = function(newSchedule,day,month,year){
		var checkIfOkay = addScheduleValidate(newSchedule);
		//Check if selected date is greater than current date date
		var date = new Date();
		var s = day + "-" + month + "-" + year;
		var inputDate = new Date(s);
		if(inputDate < date){
			$scope.dateMessage = "Selected Date should be greater than current date";
			checkIfOkay = false;
		}
		$scope.newSchedule.date_time = inputDate.getMilliseconds();
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
	//Update Schedule
	$scope.updateSchedule = function(Schedule) {
		$scope.addSchedule(Schedule);
	};


	//Delete Schedule
	$scope.deleteSchedule = function(Schedule){
		$http({
			method : 'POST',
			url : 'http://localhost:8080/schedule/delete',
			headers: { 'Content-Type': 'application/json' },
			data:Schedule
		}).success(function(data, status) {
			console.log(data);
			$scope.deleteMessage = "Sucessfully Deleted";
		}).error(function(data, status) {
			$scope.status = status;
			$scope.deleteMessage = "Request failed";
		});
	};

	//Get All Schedules
	var getAll = function($http, $scope){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/schedule/getAll',
			headers: { 'Content-Type': 'application/json' },
		}).success(function(data, status) {
			$scope.allSchedules = data;
			console.log($scope.allSchedules);
		}).error(function(data, status) {
			$scope.status = status;
			$scope.message = "Request failed";
		});
	}

	//Additional Methods for processing
	$scope.fetchAllAcademyID = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/schedule/getAcademyID',
			headers: { 'Content-Type': 'application/json' },
		}).success(function(data, status) {
			
			$scope.academyID = data;
			console.log($scope.academyID);
			$scope.enableGroup = true;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.deleteMessage = "Request failed";
		});
	};
	$scope.formatDate1 = function(milli){
		var fdate = new Date(milli);
		$scope.day = fdate.getDate();
		$scope.month = fdate.getMonth()+1;
		$scope.year = fdate.getFullYear();
	};
});

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}
