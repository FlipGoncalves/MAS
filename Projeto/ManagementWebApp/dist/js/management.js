var promos = {
  "Microsoft Madness": [
    {
      "percentagem": 50,
      "data_inicio": "08/06/2020",
      "data_fim": "12/07/2020",
      "produtos": ["i_13", "i_30", "i_44"]
    }
  ],
  "Yoga Book, Zen Price": [
    {
      "percentagem": 30,
      "data_inicio": "20/05/2020",
      "data_fim": "30/06/2020",
      "produtos": ["i_34"]
    }
  ],
  "Samsung Galaxy +": [
    {
      "percentagem": 20,
      "data_inicio": "12/06/2020",
      "data_fim": "12/08/2020",
      "produtos": ["t_67", "t_55"]
    }
  ],
  "Gamers Paradise": [
    {
      "percentagem": 60,
      "data_inicio": "08/06/2020",
      "data_fim": "12/06/2020",
      "produtos": ["i_5", "i_33", "i_25", "i_10", "i_4", "i_6"]
    }
  ]
};

var encomendas = {
  "encomendas": [
    {
      "morada": "estrada 1, lote 20",
      "distrito": "Aveiro",
      "localidade": "Ovar",
      "cod_postal": "3880-880",
      "valor": 4276,
      "telemovel": "916969696",
      "data": "20/05/2020",
      "data_entrega": "12/07/2020",
      "produtos": [
        {
          "referencia" : "i_13",
          "quantidade": 2
        },
        {
          "referencia" : "i_31",
          "quantidade": 2
        },
        {
          "referencia" : "t_20",
          "quantidade": 2
        }
      ]
    },
    {
      "morada": "avenida 8, numero 7",
      "distrito": "Porto",
      "localidade": "Gaia",
      "cod_postal": "4400-880",
      "valor": 1706,
      "telemovel": "921212121",
      "data": "17/05/2020",
      "data_entrega": "12/07/2020",
      "produtos": [
        {
          "referencia" : "i_13",
          "quantidade": 2
        },
        {
          "referencia" : "t_51",
          "quantidade": 2
        },
        {
          "referencia" : "t_20",
          "quantidade": 2
        }
      ]
    }
]}; 

var produtos = new Array();
var prod_link = new Array();
var prod_link_i = 0;
var promo_link = '';
var order_link;

$(document).ready(function () {
  $( "#content" ).load( "pages/homepage.html" );
  $.ajax({
    url: 'https://vascoregal.github.io/MAS/Projeto/products.json',
    type: "GET",
    dataType: "json",
    success: function (result) {
      produtos = result;
    },
    error: function () {
      console.log("error");
    }
  });
});

$("#homepage").click(function (){
  $( "#content" ).load( "pages/homepage.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#homepage").addClass("active");
});

$("#products").click(function (){
  $( "#content" ).load( "pages/products.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#products").addClass("active");
});

$("#onsales").click(function (){
  $( "#content" ).load( "pages/on-sales.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#onsales").addClass("active");
});

$("#orders").click(function (){
  $( "#content" ).load( "pages/orders.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#orders").addClass("active");
});

function product_link(prod, i){
  prod_link = JSON.parse(prod);
  prod_link_i = i;

  $( "#content" ).load( "pages/product.html" );
}

function products_go(){
  $( "#content" ).load( "pages/products.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#products").addClass("active");
}

function sale_createPage(){
  $( "#content" ).load( "pages/create-sale.html" );
}

function sale_editPage(){
  $( "#content" ).load( "pages/edit-sale.html" );
}

function onsales_back(){
  $( "#content" ).load( "pages/on-sales.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#onsales").addClass("active");
}

function orders_go(){
  $( "#content" ).load( "pages/orders.html" );

  $("#homepage").removeClass("active");
  $("#products").removeClass("active");
  $("#onsales").removeClass("active");
  $("#orders").removeClass("active");
  $("#orders").addClass("active");
}

function find_by_ref(ref){
  result = new Array();
  if (ref.includes("i_")){
    result[0] = 'informatica-e-acessorios';
    $.each(produtos['informatica-e-acessorios'], function(k, v) {
      $.each(v, function(kh,vh){
        if (kh == ref){
          result[1] = k;
          result[2] = vh;
        }
      });
    });
  }
  else if (ref.includes("t_")){
    result[0] = 'telemoveis-e-smartphones';
    $.each(produtos['telemoveis-e-smartphones'], function(k, v) {
      $.each(v, function(kh,vh){
        if (kh == ref){
          console.log("entrei");
          result[1] = k;
          result[2] = vh;
        }
      });
    });
  }

  return result;
}
