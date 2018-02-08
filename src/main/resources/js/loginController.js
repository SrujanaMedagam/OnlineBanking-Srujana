var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "login.html"
    })
    .when("/login", {
        templateUrl : "dashboard.html",
        controller: 'loginController'
    })
    
    
});
app.controller('loginController', function($scope,$location) {
    $scope.submit=function(){
    	$scope.username="";
    	if($scope.uname=="raja" && $scope.password=="raja1234")
    		{
    		$location.path('/login');
    		}
    	else
    		{
    		alert("Please provide correct username and password")
    		}
    	
    	
    };
});