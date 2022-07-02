
    self.Depth= ko.observable(10);


   self.DepthRepeated= ko.computed(function(){
       var ret = [];
       for(var i =0; i<self.Depth(); i++)
        ret.push(i);//note: very dirty way to create/populate an array!..but it's just for PoC

       return ret;

   });
}