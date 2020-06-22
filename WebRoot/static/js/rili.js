{
    let riliContent=document.getElementById('riliContent');
    let showTime=document.getElementById('showTime');
    let previous=document.getElementById('previous');
    let next=document.getElementById('next');

    let newDate = new Date();

    let yearNum = newDate.getFullYear();
    let monthNum = newDate.getMonth();
    let dateNum = newDate.getDate();

    let everyday = function(days){

        let year = days.getFullYear();
        let month = days.getMonth()+1;

        let lastDay = new Date(year,month,0);
        let lastDay_date = lastDay.getDate();//这个月的最后一天
        let firstDay = new Date(year,month-1,1);
        let firstDay_day = firstDay.getDay();//这个月第一天

        //上个月的最后一天
        let pDay =new Date(year,month-1,0);
        let last_p_day =pDay.getDate();

        let n=0;//前几个灰色数生成
        for (let j =0;j<firstDay_day;j++)
        {   n++;
            let LI = document.createElement("li");
            last_p_days = last_p_day - firstDay_day;
            LI.innerHTML = last_p_days+n;
            LI.style.color = "#ddd";
            riliContent.appendChild(LI);
        }
        //本月数生成
        for (let i = 1; i <= lastDay_date; i++) {
            let LI = document.createElement("li");
            LI.innerHTML = i;
            (year === newDate.getFullYear() && month === newDate.getMonth()+1 && newDate.getDate() === i)&& (LI.style.color ="red");
            riliContent.appendChild(LI);
        }
        for (let m=1; m<=42-lastDay_date-firstDay_day;m++)
        {
            let LI = document.createElement("li");
            LI.innerHTML = m;
            LI.style.color = "#ddd";
            riliContent.appendChild(LI);
        }

        showTime.innerHTML = year +"-" + month;
    };


    previous.addEventListener("click",function () {
        riliContent.innerHTML ="";
        monthNum--;
        everyday(new Date(yearNum,monthNum,dateNum));
    });

    next.addEventListener("click",function () {
        riliContent.innerHTML ="";
        monthNum++;
        everyday(new Date(yearNum,monthNum,dateNum));
    });
    everyday(newDate);

}