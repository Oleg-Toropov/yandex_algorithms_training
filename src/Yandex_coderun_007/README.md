<h1 class="title">Яндекс (CodeRun)</h1>
<p><b>dfs</b></p>
<p><b>Время: ? сек.<br>Память: ? Мб<br>Сложность: Easy</b></p>
<p>7. Поиск в глубину</p>
<p>Дан неориентированный граф, возможно, с петлями и кратными ребрами. Необходимо построить компоненту связности, содержащую вершину с номером 1.</p>
<p>Напомним:</p>
<p>Петля в графе - это ребро, которое соединяет вершину с самой собой.</p>
<p>Кратные рёбра в графе - это ребра, которые соединяют одну и ту же пару вершин.</p>
<p>Компонента связности в неориентированном графе - это подмножество вершин, таких что все вершины достижимы друг из друга.</p>

<h2>Формат ввода</h2>
<p>В первой строке записаны два целых числа N (1 ≤ N ≤ 10<sup>3</sup>) и M (0 ≤ M ≤ 5*10<sup>5</sup>) — количество вершин и ребер в графе. В последующих M строках перечислены ребра — пары чисел, определяющие номера вершин, которые соединяют ребра. Далее может идти произвольное количество пустых строк.</p>

<h2>Формат вывода</h2>
<p>В первую строку выходного файла выведите число K — количество вершин в компоненте связности. Во вторую строку выведите K целых чисел — вершины компоненты связности, перечисленные в порядке возрастания номеров.</p>

<h3>Примеры</h3>
<table class="sample-tests">
  <thead>
     <tr>
        <th>Ввод</th>
        <th>Вывод</th>
     </tr>
  </thead>
  <tbody>
     <tr>
        <td>4 5
        <br>2 2
        <br>3 4
        <br>2 3
        <br>1 3
        <br>2 4</td>
        <td>4
        <br>1 2 3 4</td>
     </tr>

  </tbody>
</table>
