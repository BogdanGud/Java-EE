

angular.module('appModule', ['appModule.controllers','dishModule.controllers']);



angular.element(document).ready(function(){
    angular.bootstrap(document, ['appModule']);
    
});


