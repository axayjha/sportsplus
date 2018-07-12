
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
		//console.log("Init");
		var date = new Date();
		$scope.currentDate = formatDate(date);
		//console.log($scope.currentDate);
		$scope.range4=[];
		for (var i = 1; i <= 12; i++) {
			$scope.range4.push(i);
		}
		$scope.fetchAllAcademyID();
		$scope.editAllowed = true;
	};

	//Creating validations and functions
	
	
	//Linking to HTML
	//Add Schedule
	$scope.addSchedule = function(newSchedule, c, u){
		var ch = addScheduleA(newSchedule,c,u);
		if(ch){
			alert("Added successfully");
		}
	};
	var addScheduleA = function(newSchedule,c,u){
		if (newSchedule == null) {
			alert("Fields cant be left empty");
			return false;
		}
		
		if(Object.keys(newSchedule).length < 4){
			alert("Fields should not be left blank");
			return false;
		}

		if(c == undefined || Object.keys(c).length < 5){
			alert("Current date should not be left blank");
			return false;
		}
		if(u == undefined || Object.keys(u).length < 5){
			alert("Updated date should not be left blank");
			return false;
		}
		
		//Check if selected date is greater than current date date
		var v = new Date(c.yy,c.mm-1,c.dd,c.hrs,c.min,0,0);
		var date = new Date()
		console.log(v);
		var v1 = new Date(u.yy,u.mm-1,u.dd,u.hrs,u.min,0,0);
		if(v < date){
			$scope.dateMessage = "Selected Date should be greater than current date";
			//console.log("error");
			alert("Selected Date should be greater than current date");
			return false;
		}
		if(v1 < date){
			$scope.dateMessage = "Updated Date should be greater than current date";
			//console.log("error");
			alert("Updated Date should be greater than current date");
			return false;
		}
		newSchedule.date_time = v.getTime();
		newSchedule.updated_time = v1.getTime();
		//console.log(newSchedule);
		
			
		$http({
			method : 'POST',
			url : 'http://localhost:8080/schedule/add',
			headers: { 'Content-Type': 'application/json' },
			data:newSchedule
		}).success(function(data, status) {
			//console.log(data);
			$scope.getAll();
			alert("Sucessful Operation");
			return data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
			return false;
		});
		
	};
	//Update Schedule
	$scope.updateSchedule = function(Schedule, sc, su) {
		var ch = addScheduleA(Schedule, sc, su);
		
		if(ch){
			alert("Updated successfully");
		}
		return ch;
	};


	//Delete Schedule
	$scope.deleteSchedule = function(Schedule){
		$http({
			method : 'POST',
			url : 'http://localhost:8080/schedule/delete',
			headers: { 'Content-Type': 'application/json' },
			data:Schedule
		}).success(function(data, status) {
			//console.log(data);
			alert("Successfully Deleted");
			$scope.getAll();
			$scope.deleteMessage = "Sucessfully Deleted";
		}).error(function(data, status) {
			$scope.status = status;
			$scope.deleteMessage = "Request failed";
		});
	};

	//Get All Schedules
	
	$scope.getAll = function(){
		//console.log("Trigger");
		$http({
			method : 'GET',
			url : 'http://localhost:8080/schedule/getAll',
			headers: { 'Content-Type': 'application/json' },
		}).success(function(data, status) {
			$scope.allSchedules = data;
			//console.log($scope.allSchedules);
		}).error(function(data, status) {
			$scope.status = status;
			$scope.message = "Request failed";
		});
	};

	//Additional Methods for processing
	$scope.fetchAllAcademyID = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/schedule/getAcademyID',
			headers: { 'Content-Type': 'application/json' },
		}).success(function(data, status) {
			$scope.academyID = data;
			//console.log($scope.academyID);
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

	$scope.fetchAllGroupID = function(s){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/schedule/getGroupID',
			headers: { 'Content-Type': 'application/json' },
		}).success(function(data, status) {
			//console.log(s);
			//console.log(data);
			$scope.groupID = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.deleteMessage = "Request failed";
		});
	};

	$scope.resetForm = function(){
		$scope.user = angular.copy($scope.initial);
	};

	$scope.cpy = function(){
		if($scope.cpyDate){
			$scope.u = $scope.c;
		}else{
			$scope.u = null;
		}
	};

	$scope.dispDate = function(date) {
		var d = new Date(date);
		var obj = {
			dd : d.getDate(),
			mm : d.getMonth()+1,
			yy : d.getFullYear(),
			hrs: d.getHours(),
			min : d.getMinutes()
		};
		return obj;
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
