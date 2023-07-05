<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="format.css">
</head>

<body>
    <h2>Stock Rankings <span class="developer">Developer Justin Pope</span></h2>

    <?php include('function.php');
    $ranking = get("ranking", 15);
    ?>

    <form>
        <label>ranking: </label> <input id="tb" class="number" type="number" name="ranking" value="<?= $ranking ?>" />
        <input type="submit" value="query"/>
    </form>
    <p> <ol>
        <li>highlight (green) companies with a market cap greater or equal to 40 billion dollars </li>
        <li>highlight (red) companies with a market cap less than or equal to .15 billion dollars </li>
    </p>
    <br />
    <table>

        <head>
            <tr>
                <th>rank</th>
                <th>symbol</th>
                <th>company</th>
                <th>quant</th>
                <th>sa authors</th>
                <th>wall street</th>
                <th>market cap in billions</th>
            </tr>
            </thead>

            <tbody>

                <?php
                $file = fopen("./data/TopStocks.csv", "r");
                $count = 0;

                $row = fgetcsv($file);

                while (!feof($file)) {
                    $row = fgetcsv($file);
                    $rank = $row[0];
                    $symbol = $row[1];
                    $companyName = $row[2];
                    $quant = $row[3];
                    $saAuthors = $row[4];
                    $wallStreet = $row[5];
                    $marketCap = $row[6];
                    ?>

                    <tr class="<?= highlight(money_in_billions($marketCap)) ?>">
                        <td><?= $rank ?></td>
                        <td><?= $symbol ?></td>
                        <td><?= $companyName ?></td>
                        <td class="number"><?= qpa($quant) ?></td>
                        <td class="number"><?= qpa($saAuthors) ?></td>
                        <td class="number"><?= qpa($wallStreet) ?></td>
                        <td class="number"><?= money_in_billions($marketCap) ?></td>
                    </tr>

                    <?php
                    $count++;
                    if ($count >= $ranking) {
                        break;
                    }
        }

        fclose($file);?>  
</tbody>
</table>
</body>
</html>