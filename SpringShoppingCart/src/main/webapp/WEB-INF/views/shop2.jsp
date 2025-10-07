<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Item" %>

<form:form action="/form1/shop2" method="POST" modelAttribute="shop2Obj">
    <h1>Namkeen Shop - Shop 2</h1>

    <%
        List<Item> items = (List<Item>) request.getAttribute("items");
        if (items != null) {
            for (Item item : items) {
    %>
                <label>
                    <input type="checkbox" name="selectedItems" value="<%= item.getItemDesc() %>" />
                    <input type="hidden" name="selectedPrices" value="${item.price}" />
				   <%= item.getItemDesc() %> - Rs <%= item.getItemPrice() %>
                </label><br/>
    <%
            }
        }
    %>

    <input type="submit" value="Next Shop" />
</form:form>

<form action="${pageContext.request.contextPath}/form1/logout" method="post">
    <button type="submit">Logout</button>
</form>
