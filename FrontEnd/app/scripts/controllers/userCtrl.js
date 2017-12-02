'use strict';
/**
 * Created by famancil on 23-08-16.
 */

 angular.module('frontendApp')
  .controller('myCtrl', function($scope,$http,alert) {
    $scope.title='Listar Usuario';

    //Función para activar los modales para crear, modificar y borrar un usuario

    $scope.modalNewUser = function(){
            alert.newUser('modalNewUser.html',-1);
    };
    $scope.modalUpdateUser = function(id){
            alert.newUser('modalUpdateUser.html',id);
    };
    $scope.modalDeleteUser = function(id){
            alert.newUser('modalDeleteUser.html',id);
    };

    //Consulta HTTP GET para listar todos los usuarios.

    $http.get('http://192.168.122.1:8080/ch01/api/users')
            .then(function (data) {
                $scope.users=data.data;
            });
  });