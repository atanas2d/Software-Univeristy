/**
 * Created by atanasWin on 2/7/2014.
 */
function changeResult() {
    var resultImg = document.getElementById("result-img");
    var colorValue = document.getElementById("select-color").value;
    var radios = document.getElementsByName("extras");
    var checkedRadioId;
    for (var e in radios) {
            if (radios[e].checked) {
                checkedRadioId = radios[e].getAttribute("id").valueOf();
            }
    }
    console.log(colorValue);
    resultImg.style.backgroundColor = colorValue;
    resultImg.style.boxShadow = "0 0 20px 10px " + colorValue;
    switch  (checkedRadioId) {
        case "extra-1":
            resultImg.src = "images/nakovHead.png";
            break;
        case "extra-2":
            resultImg.src = "images/nakovShaved.png";

            break;
        case "extra-3":
            resultImg.src = "images/nakovLongHair.png";
            break;
        case "extra-4":
            resultImg.src = "images/nakovHeadOptical.png";
            break;
        case "extra-5":
            resultImg.src = "images/nakovNakedHead.png";
            break;
        case "extra-6":
            resultImg.src = "images/blank.png";
            break;
    }
}