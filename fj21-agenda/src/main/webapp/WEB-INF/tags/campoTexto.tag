<%@ attribute name="id" required="true" %>
<%@ attribute name="rotulo" required="true" %>

<div class="form-floating mt-3 mb-3">
	<input type="text" class="form-control" id="${id}" placeholder="${rotulo}" name="${id}">
	<label for="${id}">${rotulo}</label>
</div>