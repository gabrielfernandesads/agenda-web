
<!-- Capítulo-8 Tags customizadas com TagFiles -->

<%@ attribute name="id" required="true" %>
<input type="text" id="${id}" name="${id}" />
<script type="text/javascript">
$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>