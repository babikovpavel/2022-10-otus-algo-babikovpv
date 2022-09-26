# Двоичное дерево поиска

<table>
<tr>
<th colspan="4">Измерения скорости работы</th>
</tr>
<tr>
    <th>Тест</th><th>1 попытка  (ms)</th><th>2попытка (ms)</th><th>3 попытка (ms)</th>
</tr>
<tr>
    <td>Добавление 10к элементов (random)</td><td>1</td><td>1</td><td>1</td>
</tr>
<tr>
    <td>Поиск 100 случ. чисел (random)</td><td>1</td><td>1</td><td>0</td>
</tr>
<tr>
    <td>Удаление 100 случ. чисел (random)</td><td>0</td><td>0</td><td>0</td>
</tr>
<tr>
    <td>Добавление 10к элементов (serial)</td><td>229</td><td>232</td><td>233</td>
</tr>
<tr>
    <td>Поиск 100 случ. чисел (serial)</td><td>4</td><td>3</td><td>3</td>
</tr>
<tr>
    <td>Удаление 100 случ. чисел (serial)</td><td>6</td><td>5</td><td>5</td>
</tr>
</table>