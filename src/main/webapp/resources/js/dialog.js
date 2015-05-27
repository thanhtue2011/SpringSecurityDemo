function Xoa(id){
	var dialog = $('<div title="Delete">Are you sure delete?</div>').dialog({
		autoOpen: false,
        modal: true,
    buttons: {
        "Yes": function() {
        	dialog.dialog('close');
        	document.getElementById(id).submit();
        	},
        "Cancel":  function() {
                 dialog.dialog('close');
             }
       
    }
});
	dialog.dialog('open');
}
