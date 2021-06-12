@echo off

if exist pressure.txt (

rem get lines from the 100rd line

  set n=1

  SetLocal EnableDelayedExpansion

  for /f "delims=" %%i in (pressure.txt) do (

    echo %%i

    if !n! geq 100 if !n! leq 200 (

      echo %%i >> 100to200pressure.txt

   ) else (

      echo not matching...

    )

    set /a n=!n!+1

  )

) else (

  echo not found pressure.txt

)
