define(['durandal/app'], function (app) {
    var vm = function () {
        console.log('ViewModel initiated...');
        //---Variáveis locais
        var self = this;
        var baseUri = 'http://ieeta-cloudpt.web.ua.pt/pokemons/api/Search?name=';
        self.displayName = 'Pokémon Specie Details';
        self.error = ko.observable('');
        self.records = ko.observable();
        self.activate = function (id) {
            // Activation code here
            console.log('CALL: Search...');
            var composedUri = baseUri + id;
            console.log("composedUri = " + composedUri);
            ajaxHelper(composedUri, 'GET').done(function (data) {
                self.records(data);
            });
        };
        //--- Internal functions
        function ajaxHelper(uri, method, data) {
            self.error(''); // Clear error message
            return $.ajax({
                type: method,
                url: uri,
                dataType: 'json',
                contentType: 'application/json',
                data: data ? JSON.stringify(data) : null,
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("AJAX Call[" + uri + "] Fail...");
                    self.error(errorThrown);
                }
            });
        }
    };

    return vm;
});