

// page text

define(['durandal/app'], function (app) {
    var page = function () {
        var self = this;
        self.records = ko.observableArray([]);
        self.displayName = 'Welcome to BuyAway';
        self.description = 'Insert Cool description';
        self.features = [
            'Pesquisar por Produtos;',
            'Adicionar Produtos ao carrinho;',
            'Procurar por Produtos numa loja;',
            'Another one(Dj Khaled)'
        ];
        self.slides = [
            //slides para produtos em promocao ou mais vistos
            { Id: 'product1', displayReference: 'Check this new product', link: '#' },
            { Id: 'product2', displayReference: 'Check this product based on your last buy', link: '#' },
            { Id: 'product3', displayReference: 'This product is in discount', link: '#' }
        ];
        // carousel
        function ajaxHelper() {
            return $.getJSON('\companies.json', function (data) {
                self.records(data.companies);
                console.log(data);
            }).fail(function () {
                console.log("error");
            }).always(function () {
                console.log("complete");
            });
        }
        var myCarouselTO = setTimeout(function () {
            console.log('carousel yey ')
            $('#myCarousel').carousel({
                interval: 4000,
                cycle: true,
                pause: "hover"
            }).trigger('slide');
        }, 2000);
        var q = myCarouselTO;
        $(".item").click(function () {
            $("#myCarousel").carousel(0);
        });
        $(".item2").click(function () {
            $("#myCarousel").carousel(1);
        });
        $(".item3").click(function () {
            $("#myCarousel").carousel(2);
        });
        $(".item4").click(function () {
            $("#myCarousel").carousel(3);
        });
        ajaxHelper();

        // BUTTONS

        $(".carousel-control-prev").click(function () {
            $("#myCarousel").carousel("prev");
        });
        $(".carousel-control-next").click(function () {
            $("#myCarousel").carousel("next");
        });
    };

    return page;
});

