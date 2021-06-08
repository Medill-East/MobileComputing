@echo off

if exist magnet.txt (

rem get lines from the 100rd line

  set n=1

  SetLocal EnableDelayedExpansion

  for /f "delims=" %%i in (magnet.txt) do (

    echo %%i

    if !n! geq 100 if !n! leq 200 (

      echo %%i >> 100to200magnet.txt

   ) else (

      echo not matching...

    )

    set /a n=!n!+1

  )

) else (

  echo not found magnet.txt

)
