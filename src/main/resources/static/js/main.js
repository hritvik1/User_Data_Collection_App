function removeAddBtn() {
  document.getElementById('add').style.display = 'none'
}

function removeShowBtn() {
  document.getElementById('show').style.display = 'none'
}

function confirmDelete() {
  const confirmDel = confirm("Are You Sure You Want To Delete This User!!!!");
  if (confirmDel === true) {
    return true
  } else {
    return false
  }
}
