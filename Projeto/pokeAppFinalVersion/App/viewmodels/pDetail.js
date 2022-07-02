define(['durandal/app'], function (app) {
    var vm = function () {
        console.log('ViewModel initiated...');
        //---Variáveis locais
        var self = this;
        self.displayName = 'Product Details';
        self.error = ko.observable('');
        self.record1 = ko.observable();
        self.produto1 = ko.observable();
        self.Depth = ko.observable();
        this.qSelect = ko.observable("");
        self.DepthRepeated = ko.computed(function () {
            var ret = [];
            for (var i = 1; i < (self.Depth() * 1) + 1; i++)
                ret.push(i); //note: very dirty way to create/populate an array!..but it's just for PoC
            return ret;

        }, self);
        self.activate = function (id) {
            console.log("oactivate");
            ajaxHelper().done(function (data) {
                console.log(self.record1().length * 1);
                for (i = 0; i < (self.record1().length * 1); i++) {
                    if (self.record1()[i].referencia * 1 == id * 1) {
                        self.produto1(self.record1()[i]);
                        console.log("at long last ");
                        console.log(self.produto1(self.record1()[i]));
                        self.Depth(self.produto1().quantidade);
                    }
                }
            }).fail(function () {
                console.log("error");
            }).always(function () {
            });
        };

        //--- Internal functions
        function ajaxHelper() {
            return $.getJSON('\products.json', function (data) {
                self.record1(data.informatica);
            }).fail(function () {
                console.log("error");
            }).always(function () {
                console.log("complete");
            });
        }
        self.addItem = function (info) {
            if (example.items.indexOf(info) == -1) {
                info.quantidadeF = info.quantidade - self.qSelect();
                info.quantidadeS = self.qSelect();
                console.log(info.quantidade);
                example.items.push(info);
                console.log(example.items());
            }
        };


    };
    return vm;
});