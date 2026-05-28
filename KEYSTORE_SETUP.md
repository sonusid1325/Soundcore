# 🔐 Keystore Setup for GitHub Actions

This guide shows you how to add your `.jks` keystore to GitHub Secrets so the
CI workflow can sign your APKs automatically.

---

## Step 1 — Convert your keystore to Base64

Run this command in your terminal from the project root:

```bash
base64 -w 0 Koiverse.jks > keystore.b64
cat keystore.b64
```

> **`-w 0`** disables line-wrapping so the output is a single line — this is
> required for GitHub Secrets.

Copy the entire output (it will look like a long string of random characters).

---

## Step 2 — Add Secrets to GitHub

Go to your repository on GitHub:

```
GitHub Repo → Settings → Secrets and variables → Actions → New repository secret
```

Add these **4 secrets** (names must match exactly):

| Secret Name         | Value                                         |
|---------------------|-----------------------------------------------|
| `KEYSTORE_BASE64`   | The base64 string from Step 1                 |
| `KEYSTORE_PASSWORD` | Your keystore store password                  |
| `KEY_ALIAS`         | The key alias (check with `keytool` below)    |
| `KEY_PASSWORD`      | Your key password (often same as store password) |

### How to find your key alias

```bash
keytool -list -v -keystore Koiverse.jks
```

It will ask for the store password, then print something like:

```
Alias name: soundcore
...
```

Use that alias value for `KEY_ALIAS`.

---

## Step 3 — Optional secrets

These are only needed if you use the features:

| Secret Name            | Used for                        |
|------------------------|---------------------------------|
| `LASTFM_API_KEY`       | Last.fm scrobbling              |
| `LASTFM_SECRET`        | Last.fm scrobbling              |
| `TOGETHER_BEARER_TOKEN`| Music Together feature          |
| `CANVAS_BEARER_TOKEN`  | Spotify Canvas feature          |

---

## Step 4 — Run the workflow

### Option A — Manual trigger (any time)

1. Go to **Actions** tab on GitHub
2. Click **"Release Build — All Variants"**
3. Click **"Run workflow"**
4. Choose whether to create a GitHub Release
5. Click **"Run workflow"** ✅

### Option B — Automatic on tag push

```bash
# Bump versionName in app/build.gradle.kts first, then:
git tag v1.0.0
git push origin v1.0.0
```

This will automatically:
- Build all 6 APK variants (mobile-arm64, mobile-armeabi, mobile-x86, mobile-x86_64, mobile-universal, tv-universal)
- Sign each APK with your keystore
- Create a GitHub Release with all APKs attached

---

## Variants built

| Variant              | Target device                    |
|----------------------|----------------------------------|
| `mobile-universal`   | All Android phones (recommended) |
| `mobile-arm64`       | Modern phones (ARM64)            |
| `mobile-armeabi`     | Older phones (ARMv7)             |
| `mobile-x86`         | Emulators / Intel tablets        |
| `mobile-x86_64`      | x86_64 emulators                 |
| `tv-universal`       | Android TV devices               |

---

## Security notes

- ✅ The keystore is stored as an encrypted GitHub Secret — GitHub employees cannot read it
- ✅ The decoded keystore file is never committed to the repo
- ✅ Secrets are not printed in logs
- ⚠️ Never commit your `.jks` file or the base64 string to the repository
- The `Koiverse.jks` at the repo root should be added to `.gitignore` if not already

### Add keystore to .gitignore

```bash
echo "*.jks" >> .gitignore
echo "*.keystore" >> .gitignore
echo "keystore.b64" >> .gitignore
```
