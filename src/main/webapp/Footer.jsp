<style>

  .footer-container {
    background-color:#332821;
  }

  .footer-form input[type="email"] {
    background-color: transparent;
    border: none;
    border-bottom: 1px solid white;
    border-radius: 0;
    color: white;
  }

  .footer-form label {
    color: white;
  }

  .footer-submit-btn {
    background-color: transparent;
    border: 1px solid white;
    color: white;
  }

  .footer-submit-btn:hover {
    background-color: white;
    color: black;
  }

  .footer-text {
    background-color: rgba(0, 0, 0, 0.2);
    color: white;
  }

  html, body {
    height: 100%;
  }

  .footer-container {
    min-height: 100%;
  }

  .wrapper {
    padding-bottom: 60px; /* Height of the footer */
  }
</style>

<div class="footer-container my-5" >
  <!-- Replace <footer> with <div> -->
  <div class="text-center text-white">
    <!-- Grid container -->
    <div class="container p-4 pb-0">
      <!-- Section: Form -->
      <section class="footer-section">
        <form action="">
          <!--Grid row-->
          <div class="row d-flex justify-content-center">
            <!--Grid column-->
            <div class="col-auto">
              <p class="pt-2">
                <strong>Sign up for our newsletter</strong>
              </p>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-5 col-12">
              <!-- Email input -->
              <div class="form-outline form-white mb-4 footer-form">
                <input type="email" id="form5Example2" class="form-control" />
                <label class="form-label" for="form5Example2">Email address</label>
              </div>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-auto">
              <!-- Submit button -->
              <button type="submit" class="btn btn-outline-light mb-4 footer-submit-btn">
                Subscribe
              </button>
            </div>
            <!--Grid column-->
          </div>
          <!--Grid row-->
        </form>
      </section>
      <!-- Section: Form -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3 footer-text">
      © 2023 Institut International Technologie
    </div>
    <!-- Copyright -->
  </div>
</div>
