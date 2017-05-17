var _ctx = $("meta[name='ctx']").attr("content");
var arrLabel = [];
var arrData = [];
var arrColor = [];
var arrLabelData = [];

$(document).ready(function () {
    setMenuActive("religion-list");
    var jqxhr = $.getJSON(_ctx + "/religionrest", function (json) {
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
                    arrLabel.push(obj.religion);
                    arrData.push(obj.individuals);
                    individualsTotal = individualsTotal + parseInt(obj.individuals);
                    arrColor.push(color[i + startFrom ][2]);
                    arrLabelData.push([]);
                    arrLabelData[i][0] = obj.religion;
                    arrLabelData[i][1] = parseInt(obj.individuals);
                    arrLabelData[i][2] = 0;
                });
                for (var i in arrLabelData) {
                    var individuals = 0;
                    individuals = parseInt(arrLabelData[i][1]);
                    arrLabelData[i][2] = 100 * individuals / individualsTotal;
                }                
                $('.loading').hide();                
                $('.religion').animate(
                    {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);
        
        
        
                var defBtns = [{
                    extend: 'csvHtml5',
                    filename: 'religon',
                    title: 'religion',
                    exportOptions: {columns: [0, 1, 2]}
                }, {
                    extend: 'excelHtml5',
                    filename: 'religion',
                    title: 'religion',
                    exportOptions: {columns: [0, 1, 2]}
                }, {
                    extend: 'pdfHtml5',
                    filename: 'religion',
                    title: 'religion',
                    exportOptions: {columns: [0, 1, 2]}
                }];

                var defCols = [
                    {'title': 'Religion'},
                    {'title': 'Individuals', render: $.fn.dataTable.render.number(',', '.', 0), 'className': 'numeric'},
                    //{'title': 'Percentage (%)',render: $.fn.dataTable.render.number(',', '.', 1, '%'),'className': 'numeric'}
                    {'title': 'Percentage (%)', render: $.fn.dataTable.render.number(',', '.', 3), 'className': 'numeric'}
                ];

                renderTable("religionlist", defBtns,defCols,arrLabelData);
                renderDoughnut(arrData,arrColor,arrLabel);

            });

});




function callBackHide() {
    setTimeout(function () {
        $("#center").fadeOut();
    }, 1000);
}
;
function callBackShow() {
    setTimeout(function () {
        $("#center").fadeIn();
    }, 1000);
}
;

