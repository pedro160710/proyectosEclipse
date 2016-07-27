var app= angular.module("moduloAplicacion");
app.controller('miControlador', function($scope,adminLibroSrv){
	$scope.valorDeBusqueda="";
	$scope.error;

// aqui llamar lasfunciones que se van a invocar como callback en el metodo then
	$scope.buscarLibro = function(){
			adminLibroSrv.buscarLibro($scope.valorDeBusqueda, 
					function(librosEncontrados){
				console.log("libros escontrados"+librosEncontrados);
				$scope.libros= librosEncontrados;
			}, function(mensajeError){
				$scope.error= mensajeError;
			});
	};


	
});