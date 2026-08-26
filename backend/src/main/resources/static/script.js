const form = document.getElementById("ageForm");
const result = document.getElementById("result");
const error = document.getElementById("error");

form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const name = document.getElementById("name").value.trim();
    const dob = document.getElementById("dob").value;

    result.classList.add("hidden");
    error.classList.add("hidden");

    try {
        const response = await fetch("/api/calculate-age", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                dob: dob
            })
        });

        const data = await response.json();

        if (!response.ok) {
            throw new Error(data.message || "Unable to calculate age");
        }
        document.getElementById("ageNumber").textContent = data.age;
        document.getElementById("resultName").textContent = name;

        const date = new Date(dob + "T00:00:00");

        const formattedDate = date.toLocaleDateString("en-GB", {
            day: "2-digit",
            month: "long",
            year: "numeric"
        });

        document.getElementById("resultDob").textContent = formattedDate;

        result.classList.remove("hidden");
    } catch (err) {
        console.error("API Error:", err);
        error.textContent = err.message || "Unable to connect to the server.";
        error.classList.remove("hidden");
    }
});