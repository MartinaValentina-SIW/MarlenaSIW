let buttonPremi = document.getElementsByClassName("ottieniPremio");

var i = 0;
for(i=0; i<buttonPremi.length;i++)
{
     if(buttonPremi[i].innerHTML === "Gia' ottenuto")
      {
        buttonPremi[i].style.color = "red";
        buttonPremi[i].setAttribute("disabled","disabled");
      }
}
