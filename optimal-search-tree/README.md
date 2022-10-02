# Оптимальные деревья поиска

<table>
<tr>
<th colspan="5">Измерения скорости работы</th>
</tr>
<tr>
    <th>Тип дерева</th><th>Тест</th><th>1 попытка  (ms)</th><th>2попытка (ms)</th><th>3 попытка (ms)</th>
</tr>
<tr>
    <td rowspan="9"><b>SplayBinaryTree</b></td>
</tr>
<tr>
    <td>Добавление 10к элементов (random)</td><td>4</td><td>5</td><td>5</td>
</tr>
<tr>
    <td>Поиск 1000 случ. чисел (random)</td><td>1</td><td>0</td><td>0</td>
</tr>
<tr>
    <td>Поиск 1000 раз чисел от 1 до 10 (random)</td><td>1</td><td>0</td><td>0</td>
</tr>
<tr>
    <td>Удаление 1000 случ. чисел (random)</td><td>0</td><td>1</td><td>1</td>
</tr>
<tr>
    <td>Добавление 10к элементов (serial)</td><td>2</td><td>1</td><td>1</td>
</tr>
<tr>
    <td>Поиск 1000 случ. чисел (serial)</td><td>8</td><td>8</td><td>10</td>
</tr>
<tr>
    <td>Поиск 1000 раз чисел от 1 до 10 (serial)</td><td>0</td><td>0</td><td>1</td>
</tr>
<tr>
    <td>Удаление 1000 случ. чисел (serial)</td><td>1</td><td>0</td><td>1</td>
</tr>
<tr>
    <td rowspan="9"><b>RandomizedBinaryTree</b></td>
</tr>
<tr>
    <td>Добавление 10к элементов (random)</td><td>2</td><td>5</td><td>4</td>
</tr>
<tr>
    <td>Поиск 1000 случ. чисел (random)</td><td>1</td><td>1</td><td>0</td>
</tr>
<tr>
    <td>Поиск 1000 раз чисел от 1 до 10 (random)</td><td>0</td><td>0</td><td>1</td>
</tr>
<tr>
    <td>Удаление 1000 случ. чисел (random)</td><td>1</td><td>0</td><td>0</td>
</tr>
<tr>
    <td>Добавление 10к элементов (serial)</td><td>2</td><td>3</td><td>2</td>
</tr>
<tr>
    <td>Поиск 1000 случ. чисел (serial)</td><td>9</td><td>7</td><td>9</td>
</tr>
<tr>
    <td>Поиск 1000 раз чисел от 1 до 10 (serial)</td><td>0</td><td>0</td><td>0</td>
</tr>
<tr>
    <td>Удаление 1000 случ. чисел (serial)</td><td>0</td><td>0</td><td>0</td>
</tr>
</table>