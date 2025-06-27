<%@ page import="org.springframework.validation.FieldError" %>

<div class="fieldcontain ${hasErrors(bean: bean, field: property, 'error')} ${required ? 'required' : ''}">
    <label for="${property}">
        ${label}
        <g:if test="${required}"><span class="required-indicator">*</span></g:if>
    </label>
    
    <g:select
        name="${property}"
        from="${bean.getClass().getPropertyType(property).values()}"
        value="${value}"
        optionKey="name"
        optionValue="toString"
        noSelection="['': '- Selecione -']"
    />
</div>