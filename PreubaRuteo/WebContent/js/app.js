var app = angular.module('MainApp',['ngRoute']);

app.controller('MainController', function($scope, $route, $routeParams, $location) {
     $scope.$route = $route;
     $scope.$location = $location;
     $scope.$routeParams = $routeParams;
 });


app.config(function ($routeProvider) {
	$routeProvider
	   .when('/Contenido1/:paramA',  {
                   templateUrl: 'contenido1.html',
                   controller: 'Controlador1'})
	   .when('/Contenido2/:paramB',  {
                   templateUrl: 'contenido2.html',
                   controller: 'Controlador2'})
	   .otherwise({
        template : "<p>Contenido no seleccionado</p>"
        });
});
app.controller('Controlador1',function($scope){
	$scope.name='Controlador1';
});

app.controller('Controlador2',function($scope){
	$scope.name='Controlador2';
});
