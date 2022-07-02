define(['plugins/router', 'durandal/app'], function (router, app) {
    var vm = function () {
        var self = this;

        self.showChanges = function (info) {
            console.log(info);
        };


        self.qSelect = ko.observable();
        console.log('Produtos -OK');
        //---Variáveis locais
        var self = this;
        //--- Internal functions
        function ajaxHelper() {
            return $.getJSON('\products.json', function (data) {
                self.records(data.informatica);
            }).fail(function () {
                console.log("error");
            }).always(function () {
                console.log("complete");
            });
        }
    };


    return vm;
});
