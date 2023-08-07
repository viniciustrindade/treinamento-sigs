<%@ attribute name="id"%>

<input type="text" id="${id}" name="${id}" />

<script>
	$("#${id}").datepicker({dateFormat:	'dd/mm/yy'});
</script>