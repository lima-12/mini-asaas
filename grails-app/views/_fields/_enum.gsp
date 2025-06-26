<%@ page import="org.springframework.validation.FieldError" %>

<%-- 
Este template é chamado pelo plugin de campos (f:all, f:field)
sempre que ele encontra uma propriedade do tipo Enum.

Variáveis disponíveis aqui:
- bean: A instância do objeto (ex: o 'customer')
- property: O nome da propriedade (ex: 'tipoPessoa')
- label: O rótulo gerado pelo Grails (ex: 'Tipo Pessoa')
- value: O valor atual da propriedade
- required: Um booleano indicando se o campo é obrigatório
--%>

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
        noSelection="['': '- Selecione -']"
    />
</div>