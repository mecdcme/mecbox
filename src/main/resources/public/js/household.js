var _ctx = $("meta[name='ctx']").attr("content");
$(".loading").hide();
$(document).ready(function () {
    setMenuActive("household-list");
    var table = $("#householdlist").DataTable({
        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>" +
                "<'row'<'col-sm-12'tr>>" +
                "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        responsive: true,
        lengthChange: false,
        pageLength: 10,
        
        buttons: [{
                extend: 'csvHtml5',
                filename: 'household',
                title: 'household'
                
            }, {
                extend: 'excelHtml5',
                filename: 'household',
                title: 'household'
                
            }, {
                extend: 'pdfHtml5',
                filename: 'household',
                title: 'household'                
        }],                 
        columnDefs: [
            {targets: [1, 2, 3, 4, 5, 6, 7, 8, 9], render: $.fn.dataTable.render.number(',', '.', 0), 'className': 'numeric'}
        ],
        //,
        //"oLanguage": {
        //    "sProcessing": "DataTables is currently busy"
        //},        
        "fnPreDrawCallback": function() {
          // $(".loading-household").show();
        },
        "fnDrawCallback": function() {
            //$(".loading-household").hide();
        }
    });
    //table.buttons().container().appendTo('#householdlist_wrapper .col-sm-6:eq(0)');
    //$('option[value=afar]').attr('selected', 'selected');
});