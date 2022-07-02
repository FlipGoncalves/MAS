define(['plugins/router', 'durandal/app'], function(router, app) {
    var vm = function() {
        console.log('carrinho -OK');
        //---Variáveis locais
        var self = this;
        self.records = ko.observableArray([]);
        ajaxHelper();
        //--- Internal functions
        function ajaxHelper() {
            return $.getJSON('\products.json', function(data) {
                self.records(data.informatica);
            }).fail(function() {
                console.log("error");
            }).always(function() {
                console.log("complete");
            });
        }
    };


    return vm;
});