define(['plugins/router', 'durandal/app'], function (router, app) {
    return {
        router: router,
        searchitem: ko.observable(""),
        selectecItems: ko.observableArray([]),
        autocompleting: function (data, event) {
            var arr = [];
            var uri = "http://ieeta-cloudpt.web.ua.pt/pokemons/api/Search?name=" + this.searchitem();
            $.ajax({
                type: "GET",
                url: uri,
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    $.each(data, function (key, value) {
                        arr.push(value.What);
                    });
                },
            });
            console.log(arr);
            $("#searchitem").autocomplete({
                source: arr,
                minLength: 2,
                delay: 200,
            });
        },
        search: function () {
            router.navigate("#search/" + this.searchitem())
        },
        activate: function () {
            router.map([
                { route: '', title: 'Welcome', moduleId: 'viewmodels/welcome', nav: true },
                { route: 'search(/:id)', title: 'Pesquisar', moduleId: 'viewmodels/search', hash: '#search', nav: false },
                { route: 'produtos', title: 'Produtos', moduleId: 'viewmodels/produtos', hash: '#produtos', nav: true },
                { route: 'produtos(/:id)', title: 'Produtos', moduleId: 'viewmodels/produtos', hash: '#produtos', nav: false },
                { route: 'pDetail(/:id)', title: 'Produtos Details', moduleId: 'viewmodels/pDetail', hash: '#pDetail', nav: false },
                { route: 'itensC', title: 'Carrinho', moduleId: 'viewmodels/itensC', hash: '#itensC', nav: true }
            ]).buildNavigationModel();

            return router.activate();
        }
    };

});
var example = {};

var item = function (value) {
    this.value = ko.observable(value);
    this.result = ko.computed(function () {
        return this.value() + example.global();
    }, this);
};
example.items = ko.observableArray([]);
