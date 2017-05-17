var _ctx = $("meta[name='ctx']").attr("content");
var arrLabel = [];
var arrDataMale = [];
var arrDataFemale = [];
var arrColor = [];


$(document).ready(function () {

    setMenuActive("sexdistribution-list");

    var jqxhr = $.getJSON(_ctx + "/sexdistribution/restlist", function (json) {

        console.log("success");
    })
            .done(function (json) {
                console.log("second success");
            })
            .fail(function (json) {
                console.log("error");
            })
            .always(function (json) {
                console.log("complete");

                var startFrom = 55;
                var individualsTotal = 0;
                $.each(json, function (i, obj) {
                    arrLabel.push(obj.range);
                    arrDataMale.push(obj.male);
                    arrDataFemale.push(obj.female);
                });
                $('.loading').hide();
                $('.sexdistribution').animate(
                        {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);
                //var colors = Chart.helpers.color;
                var objDataset = [
                    {
                        data: arrDataMale,
                        backgroundColor: color[5][2],
                        //backgroundColor: colors(color[5][2]).alpha(0.7).rgbString(),
                        //color[8][2], 
                        label: 'Male'
                    }, {
                        data: arrDataFemale,
                        backgroundColor: color[69][2],
                        //backgroundColor:colors(color[69][2]).alpha(0.7).rgbString(),
                        // color[32][2], //gold
                        label: 'Female'
                    }];

                var textTitle = 'SEX/DISTRIBUTION';

                renderBar(objDataset, textTitle)

            });
});

