<script>
  import axios from "axios";

  const api_root = "http://localhost:8080";
  let results = [];

  let connections = [{ from: null, to: null }];

  function addRow() {
    connections = ([...connections, { from: null, to: null }])
  }
 
  function searchConnection() {
    let from = "";
    let to = "";
    for (let connection of connections) {
      from += connection.from + ","
      to += connection.to + ","
    }
    from = from.slice(0,-1);
    to = to.slice(0,-1);
    let query = "from=" + from + "&to=" + to;

    var config = {
      method: "get",
      url: api_root + "/api/v1/connection?" + query,
      headers: {},
    };

    axios(config)
      .then(function (response) {
        results = response.data;
      })
      .catch(function (error) {
        alert("Search failed");
        console.log(error);
      });
  }
</script>

<h1>Connections</h1>

{#each connections as connection}
  <div class="row justify-content-sm-center space-top">
    <div class="col-sm-1">
      <label for="from">From:</label>
    </div>
    <div class="col-sm-3">
      <input bind:value={connection.from} type="text" name="from" />
    </div>
    <div class="col-sm-1">
      <label for="to">To:</label>
    </div>
    <div class="col-sm-3">
      <input bind:value={connection.to} type="text" name="to" />
    </div>
  </div>
{/each}

<div class="row justify-content-sm-center space-top" id="buttons">
  <div class="col-sm-5" />
  <div class="col-sm-auto">
    <button type="button" class="btn btn-secondary" on:click={addRow}
      >Add row</button
    >
    <button type="submit" class="btn btn-primary" on:click={searchConnection}
      >Submit</button
    >
  </div>
</div>
<hr />
<table class="table">
  <thead>
    <tr>
      <th scope="col">From</th>
      <th scope="col">To</th>
      <th scope="col">Departure</th>
      <th scope="col">Arrival</th>
    </tr>
  </thead>
  <tbody>
    {#each results as connection}
      <tr>
        <td>{connection.from}</td>
        <td>{connection.to}</td>
        <td
          >{new Date(connection.departure).toLocaleTimeString(undefined, {
            hour: "2-digit",
            minute: "2-digit",
            day: "2-digit",
            month: "2-digit",
            year: "numeric",
          })}</td
        >
        <td
          >{new Date(connection.arrival).toLocaleTimeString(undefined, {
            hour: "2-digit",
            minute: "2-digit",
            day: "2-digit",
            month: "2-digit",
            year: "numeric",
          })}</td
        >
      </tr>
    {/each}
  </tbody>
</table>

<style>
  .space-top {
    margin-top: 1rem;
  }
</style>
