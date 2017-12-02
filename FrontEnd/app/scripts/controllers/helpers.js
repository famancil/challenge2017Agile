'use strict';
//Factory para hacer la logica de los modales.
angular.module('frontendApp')
    .factory('alert', function($uibModal) {
        function newUser(modalUrl,id) {
            return $uibModal.open({
                templateUrl: modalUrl,
                controller: function($uibModalInstance ,$scope,$http,$window){

                    $scope.newUser = {};
                    $scope.formData = $scope.newUser;
                    $scope.userid = id

                    //Se ocupara las id's para modificar datos y/o borrar un usuario especifico.

                    if(id != -1){
                        $http.get('http://192.168.122.1:8080/ch01/api/users/'+id)
                            .then(function (data) {
                                console.log(data.data);
                                $scope.formUser=data.data;
                            });
                    }

                    $scope.saveUser = function(){
                        $http.post('http://192.168.122.1:8080/ch01/api/users', $scope.formData)
                            .then(function(data) {
                                $scope.formData = {};
                                $scope.todos = data;
                                console.log(data);
                            })
                            .catch(function(Object) {
                                console.log('Error:' + Object.data);
                            });
                        $uibModalInstance.close();
                        $window.location.reload();
                    };

                    $scope.updateUser = function(id){
                        $http.put('http://192.168.122.1:8080/ch01/api/users/'+id,$scope.formUser)
                            .then(function(data) {
                                console.log(data);
                            })
                            .catch(function(Object) {
                                console.log('Error:' + Object.data);
                            });
                        $uibModalInstance.close();
                        $window.location.reload();
                    };

                    $scope.deleteUser = function(id){
                        $http.delete('http://192.168.122.1:8080/ch01/api/users/'+id)
                            .then(function(data) {
                                console.log(data);
                            })
                            .catch(function(Object) {
                                console.log('Error:' + Object.data);
                            });
                        $uibModalInstance.close();
                        $window.location.reload();
                    };



                    $scope.closeModal = function(){
                        $uibModalInstance.close();

                    };
                },
            });
        }


        return {
            newUser: newUser
        };
    });