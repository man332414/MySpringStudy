function addToCart(action)
{
	document.addForm.action = action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다.");
}

function removeFromCart(action)
{
	console.log("삭제 요청 URL " + action)
	document.removeForm.action = action;
	document.removeForm.submit();
	//window.location.reload();
}

function clearCart()
{
	document.clearForm.submit();
	//window.location.reload;
}